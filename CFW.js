addEventListener("fetch", gotten => {
  gotten.respondWith(handleRequest(gotten.request))
})

async function handleRequest(request) {
  // 接受请求(对客户端)
  if (!upgradeHeader || upgradeHeader !== "websocket") {
    return new Response("Expected Upgrade: websocket", { status: 426 })
  }

  const webSocketPair = new WebSocketPair()
  const [client, getter] = Object.values(webSocketPair)

  // 建立连接(对客户端)
  getter.accept();
  getter.addEventListener("message", message => {
    sender.send(message.data)
  });

  // 发起请求(对服务器)
  const response = await fetch(request.url, {
    headers: {
      "Upgrade": "websocket"
    }
  });
  const sender = response.webSocket;

  // 建立连接(对服务器)
  sender.accept();
  sender.addEventListener("message", msg => {
    getter.send(msg)
  });

  // 断开连接(对客户端)
  sender.addEventListener("close", event => {
    getter.close(1011)
  });

  // 断开连接(对服务器)
  getter.addEventListener("close", event => {
    sender.close(1010)
  });

  //连接成功
  return new Response(null, {
    status: 101,
    webSocket: client
  });
}
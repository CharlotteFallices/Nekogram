# Nekogram
![Logo](https://gitlab.com/Nekogram/Nekogram/-/raw/master/TMessagesProj/src/main/res/mipmap-xxxhdpi/ic_launcher.png)  
Nekogram是一只非官方的Telegram客户端.

# Download
您可以在[Google play store](https://play.google.com/store/apps/details?id=tw.nekomimi.nekogram)或[官方群组](https://t.me/NekogramAPKs)中获取应用.
您可以通过[这里](https://t.me/zuragram)获取更新消息,并在[这里](https://gitlab.com/Nekogram/Nekogram/-/issues)向我们反馈您的意见.

## API,Protocol documentation

请参阅[Telegram API帮助文档](https://core.telegram.org/api)与[MTproto的帮助文档](https://core.telegram.org/mtproto).

## Compilation Guide

1. 在[项目页面](https://github.com/CharlotteFallices/Nekogram)克隆该项目至本地.
2. 将你的`release.keystore`拷贝至`TMessagesProj/config`.
3. 在`local.properties`中填写`RELEASE_KEY_PASSWORD`,`RELEASE_KEY_ALIAS`与`RELEASE_STORE_PASSWORD`以载入你的`release.keystore`.
4. 在你的IDE中打开(**而不是载入**)这个项目.
5. 编译

## Localization

Nekogram派生于Telegram,因此我们遵循了[Telegram的本地化规则](https://translations.telegram.org/en/android/).
而对于Nekogram中特有的内容,我们以[Crowdin](https://neko.crowdin.com/nekogram)来开展本地化工作,希望您也可以帮助我们将Nekogram推向世界.
- 请务必在翻译时使用一些可可爱爱的语气!

## Contributors

感谢来自([emoji key](https://allcontributors.org/docs/en/emoji-key))的同志们:

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
| [<img src="https://avatars2.githubusercontent.com/u/42698724?s=460&v=4" width="80px;"/><br /><sub>猫耳逆变器</sub>](https://github.com/NekoInverter)<br />[💻](https://github.com/Nekogram/Nekogram/commits?author=NekoInverter "Code") | [<img src="https://avatars1.githubusercontent.com/u/18373361?s=460&v=4" width="80px;"/><br /><sub>梨子</sub>](https://github.com/rikakomoe)<br />[💻](https://github.com/Nekogram/Nekogram/commits?author=rikakomoe "Code") | [<img src="https://i.loli.net/2020/01/17/e9Z5zkG7lNwUBPE.jpg" width="80px;"/><br /><sub>呆瓜</sub>](https://t.me/Duang)<br /> [🎨](#design-duang "Design") |
| :---: | :---: | :---: |
<!-- ALL-CONTRIBUTORS-LIST:END -->

该项目遵守[all-contributors](https://github.com/kentcdodds/all-contributors)规范,我们欢迎每一个人为此作出贡献!

#License

Apply [Artistic License 2.0]()https://choosealicense.com/licenses/artistic-2.0 under the premise of complying with [GNU GPLv2](https://choosealicense.com/licenses/gpl-2.0).

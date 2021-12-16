/*
 * This is the source code of tgnet library v. 1.1
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2015-2018.
 */

#include "TLObject.h"
#include "NativeByteBuffer.h"

thread_local NativeByteBuffer *sizeCalculatorBuffer = new NativeByteBuffer(true);

TLObject::~TLObject() {

}

void TLObject::readParams(NativeByteBuffer *stream, int32_t instanceNum, bool &error) {

}

void TLObject::serializeToStream(NativeByteBuffer *stream) {

}

TLObject *TLObject::deserializeResponse(NativeByteBuffer *stream, uint32_t constructor, int32_t instanceNum, bool &error) {
    return nullptr;
}

uint32_t TLObject::getObjectSize() {
    sizeCalculatorBuffer->clearCapacity();
    serializeToStream(sizeCalculatorBuffer);
    return sizeCalculatorBuffer->capacity();
}

bool TLObject::isNeedLayer() {
    return false;
}

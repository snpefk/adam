/*
 * Copyright (C) 2020 Anton Malinskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.malinskiy.adam.request.framebuffer.screencapture

import com.malinskiy.adam.request.framebuffer.BufferedImageScreenCaptureAdapter
import com.malinskiy.adam.server.stub.StubSocket
import com.malinskiy.adam.transport.use
import kotlinx.coroutines.runBlocking
import org.junit.Test

class BufferedImageScreenCaptureAdapterTest {
    @Test(expected = UnsupportedOperationException::class)
    fun testThrowsExceptionIfUnsupportedImage() {
        val adapter = BufferedImageScreenCaptureAdapter()
        runBlocking {
            StubSocket(ByteArray(1) { 0 }).use { socket ->
                adapter.process(
                    1,
                    24,
                    1,
                    1,
                    1,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    null,
                    socket
                )
            }
        }
    }
}

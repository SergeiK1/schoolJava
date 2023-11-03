/*
 * Copyright (c) 2022-2023, the original author(s).
 *
 * This software is distributable under the BSD license. See the terms of the
 * BSD license in the documentation provided with this software.
 *
 * https://opensource.org/licenses/BSD-3-Clause
 */
package org.jline.terminal.impl.ffm;

import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import org.jline.terminal.impl.AbstractWindowsConsoleWriter;

import static org.jline.terminal.impl.ffm.Kernel32.GetStdHandle;
import static org.jline.terminal.impl.ffm.Kernel32.STD_OUTPUT_HANDLE;
import static org.jline.terminal.impl.ffm.Kernel32.WriteConsoleW;
import static org.jline.terminal.impl.ffm.Kernel32.getLastErrorMessage;

@SuppressWarnings("preview")
class NativeWinConsoleWriter extends AbstractWindowsConsoleWriter {

    private final java.lang.foreign.MemorySegment console = GetStdHandle(STD_OUTPUT_HANDLE);

    @Override
    protected void writeConsole(char[] text, int len) throws IOException {
        try (java.lang.foreign.Arena arena = java.lang.foreign.Arena.ofConfined()) {
            java.lang.foreign.MemorySegment txt = arena.allocateArray(ValueLayout.JAVA_CHAR, text);
            if (WriteConsoleW(console, txt, len, MemorySegment.NULL, MemorySegment.NULL) == 0) {
                throw new IOException("Failed to write to console: " + getLastErrorMessage());
            }
        }
    }
}

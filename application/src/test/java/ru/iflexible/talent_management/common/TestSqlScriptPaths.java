/*
 *   Copyright 2020 Russian Post
 *   <p>
 *   This source code is Russian Post Confidential Proprietary.
 *   This software is protected by copyright. All rights and titles are reserved.
 *   You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *   Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *   Legal use of the software provides receipt of a license from the right holder only.
 */

package ru.iflexible.talent_management.common;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class TestSqlScriptPaths {
    protected final String dropNotNullScriptPath;
    protected final String emptyTablesScriptPath;
    protected final String setNotNullScriptPath;
}

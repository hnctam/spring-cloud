package com.ami.pcf.dcp.util;

import com.ami.pcf.dcp.error.AppException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppUtils {

    public static void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new AppException("Expected page greater or equal 0.");
        }
        if (size <= 0) {
            throw new AppException("Expected page size greater than 0.");
        }
    }

}

package com.divisa.convetidor.api;

public record Divisa(String base_code,
                     String target_code,
                     float conversion_result) {
}

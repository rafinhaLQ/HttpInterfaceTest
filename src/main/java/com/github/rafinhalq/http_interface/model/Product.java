package com.github.rafinhalq.http_interface.model;

import java.math.BigDecimal;

public record Product(String name, String description, BigDecimal price) {
}

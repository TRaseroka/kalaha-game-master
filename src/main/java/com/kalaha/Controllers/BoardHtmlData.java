package com.kalaha.Controllers;

import lombok.Builder;

import java.util.List;

@Builder
class BoardHtmlData {
    List<Integer> rowSouth;
    List<Integer> rowNorth;
    Integer kalahaSouth;
    Integer kalahaNorth;
}

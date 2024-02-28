package com.example.tuyenltph28249.dto;

import com.example.tuyenltph28249.model.HoaDon;
import com.example.tuyenltph28249.model.PhieuGiaoHang;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PhieuGiaoHangRequest {


    private String nguoiNhan;

    private String sdtNhan;

    private String phiGiaoHang;

    private HoaDon idhoaDon;


}

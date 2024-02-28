package com.poly.luongthituyen_ph28249.dto;

import com.poly.luongthituyen_ph28249.model.HangKhachHang;
import com.poly.luongthituyen_ph28249.model.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class KhachHangRequest {

    @NotBlank(message = "Khong de trong")
    private String tenKhachHang;

    @NotBlank(message = "Khong de trong")
    private String soDienThoai;

    @NotBlank(message = "Khong de trong")
    private String gioiTinh;

    @NotBlank(message = "Khong de trong")
    private String maHang;

    @NotBlank(message = "Khong de trong")
    private String tenHang;

    public KhachHang dto(KhachHang khachHang){
        khachHang.setTenKhachHang(this.getTenKhachHang());
        khachHang.setSoDienThoai(this.getSoDienThoai());
        khachHang.setGioiTinh(Boolean.valueOf(this.getGioiTinh()));
        khachHang.setHangKhachHang(HangKhachHang.builder().maHang(Integer.valueOf(this.getMaHang())).tenHang(this.getTenHang()).build());
        return khachHang;
    }


}

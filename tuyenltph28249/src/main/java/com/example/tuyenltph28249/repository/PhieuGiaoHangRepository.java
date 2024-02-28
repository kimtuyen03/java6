package com.example.tuyenltph28249.repository;

import com.example.tuyenltph28249.dto.PhieuGiaoHangCustom;
import com.example.tuyenltph28249.model.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuGiaoHangRepository extends JpaRepository<PhieuGiaoHang, String> {
    @Query(value = "select pgh.MaPhieuGiao, pgh.NguoiNhan, pgh.SdtNhan, pgh.PhiGiaoHang, hd.NgayLap, hd.GhiChu from PhieuGiaoHang pgh join HoaDon hd on pgh.HoaDonGiao = hd.MaHoaDon", nativeQuery = true)
    List<PhieuGiaoHangCustom> getPhieuGiaoHang();
}

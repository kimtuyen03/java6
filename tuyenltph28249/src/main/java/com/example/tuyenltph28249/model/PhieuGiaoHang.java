package com.example.tuyenltph28249.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PhieuGiaoHang")
public class PhieuGiaoHang {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @Column(name = "MaPhieuGiao")
    private String maPhieuGiao;

    @Column(name = "NguoiNhan")
    private String nguoiNhan;

    @Column(name = "SdtNhan")
    private String sdtNhan;

    @Column(name = "PhiGiaoHang")
    private BigDecimal phiGiaoHang;

    @ManyToOne
    @JoinColumn(name = "HoaDonGiao")
    private HoaDon hoaDon;

}

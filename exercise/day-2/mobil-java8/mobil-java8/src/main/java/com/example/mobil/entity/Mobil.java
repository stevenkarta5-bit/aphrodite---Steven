package com.example.mobil.entity;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class Mobil {
  private Long id;

  @NotBlank
  private String merk;

  @NotBlank
  private String model;

  @Min(1980)
  private int tahun;

  @DecimalMin("0.0")
  private BigDecimal harga;

  public Mobil() {}
  public Mobil(Long id, String merk, String model, int tahun, BigDecimal harga) {
    this.id = id; this.merk = merk; this.model = model; this.tahun = tahun; this.harga = harga;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getMerk() { return merk; }
  public void setMerk(String merk) { this.merk = merk; }
  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }
  public int getTahun() { return tahun; }
  public void setTahun(int tahun) { this.tahun = tahun; }
  public BigDecimal getHarga() { return harga; }
  public void setHarga(BigDecimal harga) { this.harga = harga; }
}

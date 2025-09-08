package com.example.mobil;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/mobil")
public class MobilController {

  private final MobilRepo repo;

  public MobilController(MobilRepo repo) { this.repo = repo; }

  // GET: list semua mobil
  @GetMapping
  public List<Mobil> list() { return repo.findAll(); }

  // GET: detail by id
  @GetMapping("/{id}")
  public ResponseEntity<Mobil> get(@PathVariable Long id) {
    return repo.findById(id).map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

    @GetMapping("/{id}/merk")
    public  ResponseEntity<String> getMerkById(@PathVariable Long id){
        Mobil mobil = repo.findById(id).orElse(new Mobil());
        return ResponseEntity.ok(mobil.getMerk());
    }

  // POST: create mobil baru
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mobil> create(@Valid @RequestBody Mobil req) {
    Mobil saved = repo.save(new Mobil(null, req.getMerk(), req.getModel(), req.getTahun(), req.getHarga()));
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  // PUT: replace seluruh data mobil
  @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mobil> replace(@PathVariable Long id, @Valid @RequestBody Mobil req) {
    if (!repo.exists(id)) return ResponseEntity.notFound().build();
    req.setId(id);
    return ResponseEntity.ok(repo.save(req));
  }

  // PATCH: update sebagian field sederhana (merk/model/tahun/harga opsional)
  @PatchMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mobil> patch(@PathVariable Long id, @RequestBody Map<String, Object> body) {
    Mobil m = repo.findById(id).orElse(null);
    if (m == null) return ResponseEntity.notFound().build();
    if (body.containsKey("merk"))   m.setMerk((String) body.get("merk"));
    if (body.containsKey("model"))  m.setModel((String) body.get("model"));
    if (body.containsKey("tahun"))  m.setTahun(((Number) body.get("tahun")).intValue());
    if (body.containsKey("harga"))  m.setHarga(new java.math.BigDecimal(String.valueOf(body.get("harga"))));
    return ResponseEntity.ok(repo.save(m));
  }

  // DELETE: hapus mobil
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) { repo.delete(id); }
}

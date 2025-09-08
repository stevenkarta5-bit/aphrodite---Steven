package com.example.mobil;

import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MobilRepo {
  private final Map<Long, Mobil> data = new ConcurrentHashMap<Long, Mobil>();
  private final AtomicLong seq = new AtomicLong(0);

  public MobilRepo() {
    // seed
    save(new Mobil(null, "Toyota", "Avanza", 2019, new java.math.BigDecimal("150000000")));
    save(new Mobil(null, "Honda", "Brio", 2021, new java.math.BigDecimal("185000000")));
  }

  public List<Mobil> findAll() { return new ArrayList<Mobil>(data.values()); }
  public Optional<Mobil> findById(Long id) { return Optional.ofNullable(data.get(id)); }
  public Mobil save(Mobil m) {
    if (m.getId() == null) m.setId(seq.incrementAndGet());
    data.put(m.getId(), m);
    return m;
  }
  public void delete(Long id) { data.remove(id); }
  public boolean exists(Long id) { return data.containsKey(id); }
}

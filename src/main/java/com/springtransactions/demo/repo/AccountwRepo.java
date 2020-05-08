package com.springtransactions.demo.repo;

import com.springtransactions.demo.model.Accountw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountwRepo extends JpaRepository<Accountw,Long> {
}

package com.springtransactions.demo.repo;

import com.springtransactions.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface AccountsRepo extends JpaRepository<Account, Long> {
    List<Account> findByStaffIdIn(Set<Integer> ids);
}

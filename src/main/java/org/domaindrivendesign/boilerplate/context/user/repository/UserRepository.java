package org.domaindrivendesign.boilerplate.context.user.repository;

import org.domaindrivendesign.boilerplate.context.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String>, QuerydslPredicateExecutor<User> {
    Page<User> findAll(Pageable pageable);
}

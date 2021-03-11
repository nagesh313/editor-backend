package com.app.editorbackend.user.service;

import javassist.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Repository
@CacheConfig(cacheNames = "users")
public interface UserRepo extends JpaRepository<User, Long> {

    @CacheEvict(allEntries = true)
    <S extends User> List<S> saveAll(Iterable<S> entities);

    @Caching(evict = {
            @CacheEvict(key = "#p0.id"),
            @CacheEvict(key = "#p0.username")
    })
    <S extends User> S save(S entity);

    @Cacheable
    Optional<User> findById(Long objectId);

    @Cacheable
    default User getById(Long id) throws NotFoundException {
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        if (!optionalUser.get().isEnabled()) {
            throw new NotFoundException("User is disabled");
        }
        return optionalUser.get();
    }

    @Cacheable
    Optional<User> findByUsername(String username);

}
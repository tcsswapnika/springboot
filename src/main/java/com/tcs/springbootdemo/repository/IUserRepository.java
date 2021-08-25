package com.tcs.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tcs.springbootdemo.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

}

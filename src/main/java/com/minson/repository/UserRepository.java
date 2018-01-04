package com.minson.repository;

import com.minson.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by pocan on 2018/1/3.
 *  User表操作接口
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select t from User t where t.name = :name")
    User findByUserName(@Param("name") String name);

}

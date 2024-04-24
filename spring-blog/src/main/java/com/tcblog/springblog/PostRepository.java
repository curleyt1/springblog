package com.tcblog.springblog;

// import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // @Override
    // default Iterable<Post> findAll() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    // }

    // List<Post> findById(long id);
    
}

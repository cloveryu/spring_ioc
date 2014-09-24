package com.clover.training.repository;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookFinderImplTest {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String ISBN = "9787111446231";

}

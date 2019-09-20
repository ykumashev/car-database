package com.yernar.car.database;

import static org.assertj.core.api.Assertions.assertThat;

import com.yernar.car.database.domain.Car;
import com.yernar.car.database.domain.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository repository;

    @Test
    public void saveCar() {
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
        entityManager.persistAndFlush(car);
        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCar() {
        entityManager.persistAndFlush(new Car("Tesla", "Model X", "White",
                "ABC-1234", 2017, 86000));
        entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow",
                "BWS-3007", 2015, 24500));
        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }
}
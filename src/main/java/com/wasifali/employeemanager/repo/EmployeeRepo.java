package com.wasifali.employeemanager.repo;

import com.wasifali.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**changed the extends class from JPARepository to PagingAndSortingRepository to implement pagination with sorting
 * Conversely, we could have chosen to extend JPARepository instead, as it extends PagingAndSortingRepository too.
*/
public interface EmployeeRepo extends JpaRepository<Employee, Long> {


    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}

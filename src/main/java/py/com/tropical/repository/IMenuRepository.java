package py.com.tropical.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.tropical.entity.Menu;

public interface IMenuRepository extends PagingAndSortingRepository<Menu,Long>{

}

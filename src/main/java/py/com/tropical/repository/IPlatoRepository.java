package py.com.tropical.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.tropical.entity.Plato;


public interface IPlatoRepository extends PagingAndSortingRepository<Plato,Long>{

}
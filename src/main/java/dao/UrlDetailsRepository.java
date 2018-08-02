/**
 * 
 */
package dao;

import org.springframework.data.repository.CrudRepository;

import entity.Urldetails;

/**
 * @author rahul
 *
 */
public interface UrlDetailsRepository extends CrudRepository<Urldetails, Integer> {
	
	@SuppressWarnings("unchecked")
	public Urldetails save(Urldetails urlDetails);
    public Urldetails findByUrlDetailsID(int urlDetailsID);

}

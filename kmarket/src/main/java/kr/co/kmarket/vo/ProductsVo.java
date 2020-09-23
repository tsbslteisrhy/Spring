package kr.co.kmarket.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="km_products")
public class ProductsVo {

	@Id
	private int code;
	private int cate1;
	private int cate2;
	private String name;
	private String descript;
	private String company;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int delivery;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private String status;
	private String dutyFree;
	private String receipt;
	private String bizClass;
	private String origin;
	private String ip;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	//추가필드
	@Transient
	private MultipartFile file1;
	@Transient
	private MultipartFile file2;
	@Transient
	private MultipartFile file3;
	@Transient
	private MultipartFile file4;
}

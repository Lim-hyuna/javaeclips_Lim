package kr.green.lg.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.green.lg.pagination.Criteria;
import kr.green.lg.vo.CategoryVO;
import kr.green.lg.vo.LikesVO;
import kr.green.lg.vo.MemberVO;
import kr.green.lg.vo.ProductVO;

public interface ProductService {

	int insertCategory(CategoryVO category);

	ArrayList<CategoryVO> getCategoryList();

	void insertProduct(ProductVO product, MultipartFile file);

	ArrayList<ProductVO> selectProductList(Criteria cri);

	int getProductTotalCount(Criteria cri);

	ProductVO selectProduct(String pr_code);

	boolean deleteProduct(String pr_code);

	boolean updateProduct(ProductVO product, MultipartFile file);

	LikesVO getLikes(String pr_code, MemberVO user);

	int updateLikes(LikesVO likes);

	ArrayList<ProductVO> selectProductListByLikes(MemberVO user);

}
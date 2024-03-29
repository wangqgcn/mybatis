package quintwong.mapper;

import quintwong.pojo.Hero;
import quintwong.pojo.HeroExample;

import java.util.List;

public interface HeroMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hero
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hero
     *
     * @mbg.generated
     */
    int insert(Hero record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hero
     *
     * @mbg.generated
     */
    int insertSelective(Hero record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hero
     *
     * @mbg.generated
     */
    List<Hero> selectByExample(HeroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hero
     *
     * @mbg.generated
     */
    Hero selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hero
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Hero record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hero
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Hero record);
}
package com.wddjnn.user.dao;

import com.wddjnn.user.model.User;
import com.wddjnn.user.model.UserExample.Criteria;
import com.wddjnn.user.model.UserExample.Criterion;
import com.wddjnn.user.model.UserExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    public String countByExample(UserExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    public String deleteByExample(UserExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPassword() != null) {
            sql.VALUES("user_password", "#{userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserNickName() != null) {
            sql.VALUES("user_nick_name", "#{userNickName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.VALUES("last_login_time", "#{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.VALUES("update_user", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getYn() != null) {
            sql.VALUES("yn", "#{yn,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    public String selectByExample(UserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_name");
        sql.SELECT("phone");
        sql.SELECT("user_password");
        sql.SELECT("user_nick_name");
        sql.SELECT("status");
        sql.SELECT("last_login_time");
        sql.SELECT("create_user");
        sql.SELECT("create_time");
        sql.SELECT("update_user");
        sql.SELECT("update_time");
        sql.SELECT("yn");
        sql.FROM("user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPassword() != null) {
            sql.SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserNickName() != null) {
            sql.SET("user_nick_name = #{record.userNickName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getYn() != null) {
            sql.SET("yn = #{record.yn,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        sql.SET("user_nick_name = #{record.userNickName,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("yn = #{record.yn,jdbcType=TINYINT}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPassword() != null) {
            sql.SET("user_password = #{userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserNickName() != null) {
            sql.SET("user_nick_name = #{userNickName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.SET("last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.SET("update_user = #{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getYn() != null) {
            sql.SET("yn = #{yn,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Nov 24 15:47:39 CST 2020
     */
    protected void applyWhere(SQL sql, UserExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
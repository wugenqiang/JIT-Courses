
package com.clps.oas.util.tree;
		


/**
 * @desc: clps.oas
 * @author: lilian
 * @createTime: 2018年5月21日 下午4:11:30
 * @version: v1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.clps.oas.util.pojo.TreeNode;

/**
 * 树形结构工具类
 *
 * 将一组list对象转成树形结构
 * 该list需符合设定的字段类型
 *
 */
public class TreeUtil {


    public static Map<String,Object> mapArray = new HashMap<String, Object>();  //the map into list
    public List<TreeNode> tree;													//the list of treeNode
    public List<Object> list = new ArrayList<Object>();  					    //the list to return

   /**
    * 
    * @desc:将list转为树形结构
    * @author: lilian
    * @createTime: 2018年5月22日 上午11:17:01
    * @param menu
    * @return List<Object>
    */
    public List<Object> createTree(List<TreeNode> treeNodeList){
        this.tree = treeNodeList;
        for (TreeNode treeNode : treeNodeList) {
            Map<String,Object> mapArr = new HashMap<String, Object>();
            if(treeNode.getParentId()==0){
                setTreeMap(mapArr,treeNode);
                list.add(mapArr);
            }
        }
        return list;
    }

    /**
     * 
     * @desc:根据id查询子节点
     * @author: lilian
     * @createTime: 2018年5月22日 上午11:22:48
     * @param id
     * @return List<?>
     */
    public List<?> menuChild(int id){
        List<Object> lists = new ArrayList<Object>();
        for(TreeNode t:tree){
            Map<String,Object> childArray = new HashMap<String, Object>();
            if(t.getParentId()==id){
               setTreeMap(childArray,t);
               lists.add(childArray);
            }
        }
        return lists;
    }

    /**
     * 
     * @desc:嵌套查询和设置要返回的树形结构节点的属性
     * @author: lilian
     * @createTime: 2018年5月22日 上午11:25:00
     * @param mapArr
     * @param treeNode void
     */
    private void setTreeMap(Map<String,Object> mapArr,TreeNode treeNode){
        mapArr.put("id", treeNode.getId());
        mapArr.put("text", treeNode.getText());
        mapArr.put("parentId", treeNode.getParentId());
        List<?> childrens = menuChild(treeNode.getId());
        if(childrens.size()>0){
            mapArr.put("state","closed");
            
        }
        else{
            mapArr.put("state","open");
        }
        mapArr.put("children", menuChild(treeNode.getId()));
    }

   


}

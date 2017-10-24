package com.zp.ttshop.service.impl;

import com.zp.common.TreeNode;
import com.zp.ttshop.ItemCatService;
import com.zp.ttshop.dao.TbItemCatMapper;
import com.zp.ttshop.pojo.po.TbItemCat;
import com.zp.ttshop.pojo.po.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangpeng
 * Date: 2017/10/24
 * Time: 19:01
 * Version:V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        //创建查询模板
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> itemCatList = tbItemCatMapper.selectByExample(example);
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (int i=0;i<itemCatList.size();i++){
            TreeNode treeNode = new TreeNode();
            treeNode.setId(itemCatList.get(i).getId());
            treeNode.setText(itemCatList.get(i).getName());
            treeNode.setState(itemCatList.get(i).getIsParent()?"closed":"open");
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }
}

package com.zp.ttshop;

import com.zp.common.TreeNode;

import java.util.List;

/**
 * User: zhangpeng
 * Date: 2017/10/24
 * Time: 19:02
 * Version:V1.0
 */
public interface ItemCatService {
    List<TreeNode> listItemCats(Long parentId);
}

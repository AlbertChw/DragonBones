package com.albert.jdk;

/**
 * @description:
 * @author: Albert
 * @createDate: 2019-07-18
 * @version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        String template = "CREATE TABLE `ct_contract%s` (\n" +
                "  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
                "  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',\n" +
                "  `biz_type` tinyint(3) unsigned NOT NULL COMMENT '业务类型 1-会员费',\n" +
                "  `biz_id` varchar(60) NOT NULL COMMENT '业务id',\n" +
                "  `org_code` varchar(20) DEFAULT '' COMMENT '签署机构',\n" +
                "  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '合同签署状态：0-待处理 1-待签署 2-部分签署 3-签署失败 4-合同已过期 9-待锁定  10-合同完成',\n" +
                "  `storage_status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '合同存储状态：0-待处理 1-已保存待签署的合同文件 2-已保存签署完成的合同文件',\n" +
                "  `err_msg` varchar(500) DEFAULT '' COMMENT '失败时的错误信息',\n" +
                "  `param` text COMMENT '合同文件内容参数JSON格式(Map-->JSON)',\n" +
                "  `current_count` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '已完成签署次数',\n" +
                "  `position` varchar(500) DEFAULT '' COMMENT '签署人及签署位置json格式(Map-->JSON) key:位置,value:签署人userId。如果签名人是运满满则userId传 0',\n" +
                "  `fmd5` varchar(64) DEFAULT '' COMMENT '文件md5值',\n" +
                "  `fname` varchar(128) DEFAULT '' COMMENT '文件名',\n" +
                "  `title` varchar(50) DEFAULT '' COMMENT '合同标题',\n" +
                "  `expire_time` varchar(13) DEFAULT '' COMMENT '合同签署的到期时间',\n" +
                "  `contract_temp_id` varchar(50) DEFAULT '' COMMENT '合同模板ID',\n" +
                "  `contract_id` varchar(500) DEFAULT '' COMMENT '第三方机构的合同ID',\n" +
                "  `unsigned_file_path` varchar(500) DEFAULT '' COMMENT '待签署合同文件存放路径',\n" +
                "  `signed_file_path` varchar(500) DEFAULT '' COMMENT '签署完的合同文件存放路径',\n" +
                "  `description` varchar(200) DEFAULT '' COMMENT '合同描述',\n" +
                "  `is_valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效: 1-是 0-否',\n" +
                "  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                "  `complete_time` datetime DEFAULT NULL COMMENT '合同签署完成时间',\n" +
                "  `image_param` text COMMENT '图片参数',\n" +
                "  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
                "  `need_sign` tinyint(1) unsigned DEFAULT '1' COMMENT '是否需要签署:1-需要0-不需要',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  KEY `idx_user_id` (`user_id`),\n" +
                "  KEY `idx_biz_id` (`biz_id`,`biz_type`),\n" +
                "  KEY `idx_storage_status_status` (`storage_status`,`status`,`is_valid`),\n" +
                "  KEY `idx_complete_time_new` (`complete_time`,`storage_status`,`status`,`is_valid`,`org_code`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='电子合同';";
        System.out.println("==========================================");

        String t1 = "delete from ct_contract%s ;";

        String t2 = "SELECT COUNT(*) AS cnt FROM ct_contract%s UNION ALL  ";
        for (int i=0;i<32;i++) {
            System.out.println(String.format(t1,i));
//            System.out.println(String.format(template,i));
        }
    }

}

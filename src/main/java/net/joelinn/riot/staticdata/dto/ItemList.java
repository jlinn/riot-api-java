package net.joelinn.riot.staticdata.dto;

import java.util.Map;

/**
 * Joe Linn
 * 1/29/14
 */
public class ItemList {
    public BasicData basic;
    public Map<String, Item> data;
    public Group[] groups;
    public ItemTree[] tree;
    public String type;
    public String version;
}

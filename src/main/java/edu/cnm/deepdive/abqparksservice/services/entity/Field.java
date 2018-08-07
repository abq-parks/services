package edu.cnm.deepdive.abqparksservice.services.entity;

public class Field
{
  private String name;
  private String type;
  private String alias;
  private Integer length;

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  public String getType() { return this.type; }

  public void setType(String type) { this.type = type; }

  public String getAlias() { return this.alias; }

  public void setAlias(String alias) { this.alias = alias; }

  public Integer getLength() { return this.length; }

  public void setLength(Integer length) { this.length = length; }
}

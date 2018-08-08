package edu.cnm.deepdive.abqparksservice.services.entity;

/**
 * This is the Field class.
 */
public class Field
{
  private String name;
  private String type;
  private String alias;
  private Integer length;

  /**
   * Returns the name.
   * @return the name.
   */
  public String getName() { return this.name; }

  /**
   * Sets the name.
   * @param name the name.
   */
  public void setName(String name) { this.name = name; }

  /**
   * Returns the type.
   * @return the type.
   */
  public String getType() { return this.type; }

  /**
   * Sets the type.
   * @param type the type.
   */
  public void setType(String type) { this.type = type; }

  /**
   * Returns the alias.
   * @return the alias.
   */
  public String getAlias() { return this.alias; }

  /**
   * Sets the alias.
   * @param alias the alias.
   */
  public void setAlias(String alias) { this.alias = alias; }

  /**
   * Returns the length.
   * @return the length.
   */
  public Integer getLength() { return this.length; }

  /**
   * Sets the length.
   * @param length the length.
   */
  public void setLength(Integer length) { this.length = length; }
}

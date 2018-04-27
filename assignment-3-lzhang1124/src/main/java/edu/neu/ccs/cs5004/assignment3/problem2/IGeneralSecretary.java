package edu.neu.ccs.cs5004.assignment3.problem2;

public interface IGeneralSecretary extends Secretary{

  /**
   * Promote a general secretary{@code gs1} to legal secretary.
   *
   * @param gs1 refers the general secretary need to be promoted
   * @return a legal secretary after the employee is promoted
   */
  Secretary promote(GeneralSecretary gs1);

}

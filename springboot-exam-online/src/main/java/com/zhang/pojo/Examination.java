package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2021/01/26/13:02
 */
@Data
@Getter
@Setter
public class Examination {

    private List<Choise> choiseList;

    private List<Blank> blankList;
}

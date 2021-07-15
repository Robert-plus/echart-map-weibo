package bx.springChart.demoProject.model;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeiBoNewModel implements Serializable {
    private int id;
    private String note;
    private int noteId;
    private String onboardTime;
    private int flag;
    private int realPos;
    private long num;
    private String word;

}

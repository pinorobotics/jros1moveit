/*
 * Copyright 2021 jrosmoveit project
 * 
 * Website: https://github.com/pinorobotics/jros1moveit
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pinorobotics.jros1moveit.moveit_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;
import pinorobotics.jrosmoveit.entities.Plan;
import pinorobotics.jrosmoveit.impl.clients.movegroup.MoveGroupResult;
import pinorobotics.jrosmoveit.moveit_msgs.MoveItErrorCodesMessage;

/**
 * Definition for moveit_msgs/MoveGroupResult ====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION
 * DEFINITION ======
 */
@MessageMetadata(name = MoveGroupResultMessage.NAME, md5sum = "410501ed006c4ee01edc6b4e0526d5da")
public class MoveGroupResultMessage implements Message, Plan, MoveGroupResult {

    static final String NAME = "moveit_msgs/MoveGroupResult";

    /** An error code reflecting what went wrong */
    public MoveItErrorCodesMessage error_code = new MoveItErrorCodesMessage();

    /** The full starting state of the robot at the start of the trajectory */
    public RobotStateMessage trajectory_start = new RobotStateMessage();

    /** The trajectory that moved group produced for execution */
    public RobotTrajectoryMessage planned_trajectory = new RobotTrajectoryMessage();

    /** The trace of the trajectory recorded during execution */
    public RobotTrajectoryMessage executed_trajectory = new RobotTrajectoryMessage();

    /** The amount of time it took to complete the motion plan */
    public double planning_time;

    public MoveGroupResultMessage withErrorCode(MoveItErrorCodesMessage error_code) {
        this.error_code = error_code;
        return this;
    }

    public MoveGroupResultMessage withTrajectoryStart(RobotStateMessage trajectory_start) {
        this.trajectory_start = trajectory_start;
        return this;
    }

    public MoveGroupResultMessage withPlannedTrajectory(RobotTrajectoryMessage planned_trajectory) {
        this.planned_trajectory = planned_trajectory;
        return this;
    }

    public MoveGroupResultMessage withExecutedTrajectory(
            RobotTrajectoryMessage executed_trajectory) {
        this.executed_trajectory = executed_trajectory;
        return this;
    }

    @Override
    public MoveGroupResultMessage withPlanningTime(double planning_time) {
        this.planning_time = planning_time;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                error_code,
                trajectory_start,
                planned_trajectory,
                executed_trajectory,
                planning_time);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MoveGroupResultMessage) obj;
        return Objects.equals(error_code, other.error_code)
                && Objects.equals(trajectory_start, other.trajectory_start)
                && Objects.equals(planned_trajectory, other.planned_trajectory)
                && Objects.equals(executed_trajectory, other.executed_trajectory)
                && planning_time == other.planning_time;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "error_code", error_code,
                "trajectory_start", trajectory_start,
                "planned_trajectory", planned_trajectory,
                "executed_trajectory", executed_trajectory,
                "planning_time", planning_time);
    }

    @Override
    public double getPlanningTime() {
        return planning_time;
    }

    @Override
    public MoveItErrorCodesMessage getErrorCode() {
        return error_code;
    }
}
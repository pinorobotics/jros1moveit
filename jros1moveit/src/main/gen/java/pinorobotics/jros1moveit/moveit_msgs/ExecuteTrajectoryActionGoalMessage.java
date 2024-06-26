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

import id.jros1messages.std_msgs.HeaderMessage;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.RosInterfaceType;
import id.xfunction.XJson;
import java.util.Objects;
import pinorobotics.jros1actionlib.actionlib_msgs.Action1GoalMessage;
import pinorobotics.jros1actionlib.actionlib_msgs.GoalIdMessage;

/**
 * Definition for moveit_msgs/ExecuteTrajectoryActionGoal
 *
 * <p>====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION DEFINITION ====== ====== DO NOT MODIFY!
 * AUTOGENERATED FROM AN ACTION DEFINITION ======
 */
@MessageMetadata(
        name = ExecuteTrajectoryActionGoalMessage.NAME,
        fields = {"header", "goal_id", "goal"},
        md5sum = "36f350977c67bc94e8cd408452bad0f0",
        interfaceType = RosInterfaceType.ACTION)
public class ExecuteTrajectoryActionGoalMessage
        implements Action1GoalMessage<ExecuteTrajectoryGoalMessage> {

    static final String NAME = "moveit_msgs/ExecuteTrajectoryActionGoal";

    public HeaderMessage header = new HeaderMessage();

    public GoalIdMessage goal_id = new GoalIdMessage();

    public ExecuteTrajectoryGoalMessage goal = new ExecuteTrajectoryGoalMessage();

    public ExecuteTrajectoryActionGoalMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    @Override
    public ExecuteTrajectoryActionGoalMessage withGoalId(GoalIdMessage goal_id) {
        this.goal_id = goal_id;
        return this;
    }

    @Override
    public ExecuteTrajectoryActionGoalMessage withGoal(ExecuteTrajectoryGoalMessage goal) {
        this.goal = goal;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, goal_id, goal);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (ExecuteTrajectoryActionGoalMessage) obj;
        return Objects.equals(header, other.header)
                && Objects.equals(goal_id, other.goal_id)
                && Objects.equals(goal, other.goal);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "goal_id", goal_id,
                "goal", goal);
    }
}

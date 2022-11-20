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

/** Definition for moveit_msgs/ExecuteTrajectoryGoal */
@MessageMetadata(
        name = ExecuteTrajectoryGoalMessage.NAME,
        md5sum = "054c09e62210d7faad2f9fffdad07b57")
public class ExecuteTrajectoryGoalMessage implements Message {

    static final String NAME = "moveit_msgs/ExecuteTrajectoryGoal";

    /**
     * ====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION DEFINITION ====== The trajectory to
     * execute
     */
    public RobotTrajectoryMessage trajectory = new RobotTrajectoryMessage();

    public ExecuteTrajectoryGoalMessage withTrajectory(RobotTrajectoryMessage trajectory) {
        this.trajectory = trajectory;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trajectory);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (ExecuteTrajectoryGoalMessage) obj;
        return Objects.equals(trajectory, other.trajectory);
    }

    @Override
    public String toString() {
        return XJson.asString("trajectory", trajectory);
    }
}

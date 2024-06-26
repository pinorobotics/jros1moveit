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

import id.jros1messages.trajectory_msgs.JointTrajectoryMessage;
import id.jros1messages.trajectory_msgs.MultiDOFJointTrajectoryMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for moveit_msgs/RobotTrajectory */
@MessageMetadata(
        name = RobotTrajectoryMessage.NAME,
        fields = {"joint_trajectory", "multi_dof_joint_trajectory"},
        md5sum = "dfa9556423d709a3729bcef664bddf67")
public class RobotTrajectoryMessage implements Message {

    static final String NAME = "moveit_msgs/RobotTrajectory";

    public JointTrajectoryMessage joint_trajectory = new JointTrajectoryMessage();

    public MultiDOFJointTrajectoryMessage multi_dof_joint_trajectory =
            new MultiDOFJointTrajectoryMessage();

    public RobotTrajectoryMessage withJointTrajectory(JointTrajectoryMessage joint_trajectory) {
        this.joint_trajectory = joint_trajectory;
        return this;
    }

    public RobotTrajectoryMessage withMultiDofJointTrajectory(
            MultiDOFJointTrajectoryMessage multi_dof_joint_trajectory) {
        this.multi_dof_joint_trajectory = multi_dof_joint_trajectory;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(joint_trajectory, multi_dof_joint_trajectory);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (RobotTrajectoryMessage) obj;
        return Objects.equals(joint_trajectory, other.joint_trajectory)
                && Objects.equals(multi_dof_joint_trajectory, other.multi_dof_joint_trajectory);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "joint_trajectory", joint_trajectory,
                "multi_dof_joint_trajectory", multi_dof_joint_trajectory);
    }
}

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
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for moveit_msgs/KinematicSolverInfo */
@MessageMetadata(
        name = KinematicSolverInfoMessage.NAME,
        fields = {"joint_names", "limits", "link_names"},
        md5sum = "cc048557c0f9795c392dd80f8bb00489")
public class KinematicSolverInfoMessage implements Message {

    static final String NAME = "moveit_msgs/KinematicSolverInfo";

    /** A list of joints in the kinematic tree */
    public StringMessage[] joint_names = new StringMessage[0];

    /** A list of joint limits corresponding to the joint names */
    public JointLimitsMessage[] limits = new JointLimitsMessage[0];

    /** A list of links that the kinematics node provides solutions for */
    public StringMessage[] link_names = new StringMessage[0];

    public KinematicSolverInfoMessage withJointNames(StringMessage... joint_names) {
        this.joint_names = joint_names;
        return this;
    }

    public KinematicSolverInfoMessage withLimits(JointLimitsMessage... limits) {
        this.limits = limits;
        return this;
    }

    public KinematicSolverInfoMessage withLinkNames(StringMessage... link_names) {
        this.link_names = link_names;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Arrays.hashCode(joint_names), Arrays.hashCode(limits), Arrays.hashCode(link_names));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (KinematicSolverInfoMessage) obj;
        return Arrays.equals(joint_names, other.joint_names)
                && Arrays.equals(limits, other.limits)
                && Arrays.equals(link_names, other.link_names);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "joint_names", joint_names,
                "limits", limits,
                "link_names", link_names);
    }
}

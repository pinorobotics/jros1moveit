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
package pinorobotics.jros1moveit.tests;

import id.jros1client.JRos1Client;
import id.jros1client.JRos1ClientFactory;
import id.jrosmessages.JRosMessagesTransformer;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.std_msgs.StringMessage;
import id.jrosmessages.trajectory_msgs.JointTrajectoryPointMessage;
import id.xfunction.XJson;
import id.xfunction.logging.XLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import pinorobotics.jros1moveit.JRos1MoveItFactory;
import pinorobotics.jros1moveit.moveit_msgs.MoveGroupResultMessage;
import pinorobotics.jros1rviztools.JRos1RvizToolsFactory;
import pinorobotics.jros1tf2.JRos1Tf2Factory;
import pinorobotics.jros1tf2.tf2_msgs.LookupTransformResultMessage;
import pinorobotics.jrosmoveit.JRosMoveIt;
import pinorobotics.jrosmoveit.tests.AbstractJRosMoveItIT;
import pinorobotics.jrosrviztools.JRosRvizTools;
import pinorobotics.jrostf2.JRosTf2;
import pinorobotics.robotstate.RobotModel;
import pinorobotics.robotstate.RobotStateMonitor;
import pinorobotics.ros1robotstate.Ros1RobotStateMonitor;

@Order(2)
public class JRos1MoveItIntegrationTests
        extends AbstractJRosMoveItIT<LookupTransformResultMessage, MoveGroupResultMessage> {

    private static final String BASE_FRAME = "world";
    private JRos1Client client;
    private JRosMessagesTransformer transformer = new JRosMessagesTransformer();

    @BeforeAll
    public static void setupAll() {
        XLogger.load("jros1moveit-test.properties");
        XJson.setLimitDecimalPlaces(2);
        XJson.setNegativeZero(false);
    }

    @Override
    @BeforeEach
    public void setup() {
        client = new JRos1ClientFactory().createClient();
        super.setup();
    }

    @Override
    protected PoseMessage asPoseMessage(LookupTransformResultMessage transformMessage) {
        return transformer.asPoseMessage(transformMessage.transform.transform);
    }

    @Override
    protected void assertTransformEquals(
            LookupTransformResultMessage expected, LookupTransformResultMessage actual) {
        Assertions.assertEquals(
                expected.transform.transform.toString(), expected.transform.transform.toString());
    }

    @Override
    protected RobotStateMonitor<?> createRobotStateMonitor() {
        return new Ros1RobotStateMonitor(client);
    }

    @Override
    protected JRosTf2<LookupTransformResultMessage> createTf2() {
        return new JRos1Tf2Factory().createTf2Client(client);
    }

    @Override
    protected JRosMoveIt<MoveGroupResultMessage> createMoveIt(String groupName, RobotModel model) {
        return new JRos1MoveItFactory()
                .createMoveItClient(client, "panda_arm", new RobotModel(BASE_FRAME));
    }

    @Override
    protected JRosRvizTools createRVizTools(String baseFrame, String topicName) {
        return new JRos1RvizToolsFactory()
                .createRvizTools(client, BASE_FRAME, "/visualization_marker_array");
    }

    @Override
    protected JointTrajectoryPointMessage[] getJointTrajectoryPoints(MoveGroupResultMessage plan) {
        return plan.planned_trajectory.joint_trajectory.points;
    }

    @Override
    protected StringMessage[] getJointTrajectoryNames(MoveGroupResultMessage plan) {
        return plan.planned_trajectory.joint_trajectory.joint_names;
    }

    @Override
    protected double[] getJointStatePositions(MoveGroupResultMessage plan) {
        return plan.trajectory_start.joint_state.position;
    }

    @Override
    protected String[] getJointStateNames(MoveGroupResultMessage plan) {
        return plan.trajectory_start.joint_state.name;
    }
}

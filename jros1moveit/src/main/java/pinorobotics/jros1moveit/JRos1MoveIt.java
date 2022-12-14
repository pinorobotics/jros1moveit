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
package pinorobotics.jros1moveit;

import pinorobotics.jros1moveit.impl.clients.executetrajectory.Ros1ExecuteTrajectoryClient;
import pinorobotics.jros1moveit.impl.clients.movegroup.Ros1MoveGroupClient;
import pinorobotics.jros1moveit.moveit_msgs.ExecuteTrajectoryGoalMessage;
import pinorobotics.jros1moveit.moveit_msgs.MoveGroupGoalMessage;
import pinorobotics.jros1moveit.moveit_msgs.MoveGroupResultMessage;
import pinorobotics.jrosactionlib.JRosActionClient;
import pinorobotics.jrosmoveit.impl.AbstractJRosMoveIt;
import pinorobotics.jrosmoveit.moveit_msgs.ExecuteTrajectoryResultMessage;
import pinorobotics.robotstate.RobotModel;

/**
 * Client which allows to interact with ROS MoveIt.
 *
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public class JRos1MoveIt extends AbstractJRosMoveIt<MoveGroupResultMessage> {

    /** Creates a new instance of the client */
    public JRos1MoveIt(
            JRosActionClient<MoveGroupGoalMessage, MoveGroupResultMessage> moveGroupActionClient,
            JRosActionClient<ExecuteTrajectoryGoalMessage, ExecuteTrajectoryResultMessage>
                    executeTrajectoryActionClient,
            String groupName,
            RobotModel model) {
        super(
                new Ros1MoveGroupClient(moveGroupActionClient, groupName, model),
                new Ros1ExecuteTrajectoryClient(executeTrajectoryActionClient));
    }
}

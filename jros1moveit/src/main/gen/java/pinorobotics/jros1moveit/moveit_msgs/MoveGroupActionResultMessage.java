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
import pinorobotics.jros1actionlib.actionlib_msgs.Action1ResultMessage;
import pinorobotics.jros1actionlib.actionlib_msgs.GoalStatusMessage;

/**
 * Definition for moveit_msgs/MoveGroupActionResult ====== DO NOT MODIFY! AUTOGENERATED FROM AN
 * ACTION DEFINITION ======
 */
@MessageMetadata(
        name = MoveGroupActionResultMessage.NAME,
        md5sum = "e8f0259d9c66fae7820b6818cc47d807",
        interfaceType = RosInterfaceType.ACTION)
public class MoveGroupActionResultMessage implements Action1ResultMessage<MoveGroupResultMessage> {

    static final String NAME = "moveit_msgs/MoveGroupActionResult";

    public HeaderMessage header = new HeaderMessage();

    public GoalStatusMessage status = new GoalStatusMessage();

    public MoveGroupResultMessage result = new MoveGroupResultMessage();

    public MoveGroupActionResultMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public MoveGroupActionResultMessage withStatus(GoalStatusMessage status) {
        this.status = status;
        return this;
    }

    public MoveGroupActionResultMessage withResult(MoveGroupResultMessage result) {
        this.result = result;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, status, result);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MoveGroupActionResultMessage) obj;
        return Objects.equals(header, other.header)
                && Objects.equals(status, other.status)
                && Objects.equals(result, other.result);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "status", status,
                "result", result);
    }

    @Override
    public GoalStatusMessage getGoalStatus() {
        return status;
    }

    @Override
    public MoveGroupResultMessage getResult() {
        return result;
    }
}
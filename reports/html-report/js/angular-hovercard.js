// Copyright 2015 ThoughtWorks, Inc.

// This file is part of getgauge/html-report.

// getgauge/html-report is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// getgauge/html-report is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with getgauge/html-report.  If not, see <http://www.gnu.org/licenses/>.

'use strict';
angular.module('yaru22.hovercard', ['yaru22.hovercard.tmpls']).directive('hovercard', function () {
    return {
        restrict: 'E',
        transclude: true,
        templateUrl: 'template/angular-hovercard.tmpl',
        scope: true,
        link: function ($scope, $element, $attrs) {
            $scope.show = {};
            $scope.show.card = false;
            $scope.hoverTmplUrl = $attrs.hoverTmplUrl;
            $scope.onHoverIn = $scope.$eval($attrs.onHoverIn);
            $scope.onHoverOut = $scope.$eval($attrs.onHoverOut);
            var placement = $attrs.placement || 'bottomRight';
            $scope.hoverLabelStyle = {};
            if ($attrs.labelColor) {
                $scope.hoverLabelStyle.color = $attrs.labelColor;
            }
            $scope.hoverCardStyle = {};
            if ($attrs.background) {
                $scope.hoverCardStyle.background = $attrs.background;
            }
            if ($attrs.width) {
                $scope.hoverCardStyle.width = $attrs.width;
            }
            if (placement) {
                var positionStrings = placement.replace(/([A-Z])/g, ' $1').toLowerCase().split(' ');
                var positionObj = {};
                positionObj[positionStrings[0]] = true;
                positionObj[positionStrings[1]] = true;
                if (positionObj.bottom) {
                    $scope.hoverCardStyle.bottom = '';
                    $scope.hoverCardStyle.top = '-1em';
                    $scope.hoverCardStyle['padding-bottom'] = '';
                    $scope.hoverCardStyle['padding-top'] = '3em';
                }
                if (positionObj.top) {
                    $scope.hoverCardStyle.bottom = '-1em';
                    $scope.hoverCardStyle.top = '';
                    $scope.hoverCardStyle['padding-bottom'] = '3em';
                    $scope.hoverCardStyle['padding-top'] = '';
                }
                if (positionObj.left) {
                    $scope.hoverCardStyle.left = '';
                    $scope.hoverCardStyle.right = '-1em';
                }
                if (positionObj.right) {
                    $scope.hoverCardStyle.left = '-1em';
                    $scope.hoverCardStyle.right = '';
                }
            }
        }
    };
});
angular.module('yaru22.hovercard.tmpls', []).run([
    '$templateCache',
    function ($templateCache) {
        'use strict';
        $templateCache.put('template/angular-hovercard.tmpl', '<div class=angular-hovercard ng-mouseenter="showCard = true; onHoverIn()" ng-mouseleave="showCard = false; onHoverOut()"><label class=angular-hovercard-label ng-class="{ \'angular-hovercard-active\': showCard }" ng-style=hoverLabelStyle ng-transclude=""></label><div class=angular-hovercard-detail ng-class="{ \'angular-hovercard-active\': showCard }" ng-include=hoverTmplUrl ng-style=hoverCardStyle></div></div>');
    }
]);
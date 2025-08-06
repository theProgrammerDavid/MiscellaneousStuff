#include <opencv2/opencv.hpp>

int main(int argc, char **argv)
{
    if(argc !=2){
        std::cout << "Need 2 arguments!\n./DisplayPicture <path to picture>\n";
        std::cout << "Program will now exit"<<std::endl;
        exit(-1);
    }

    cv::Mat img = cv::imread(argv[1], -1);
    

    if (img.empty())
    {
        return -1;
    }
    cv::namedWindow("DisplayPicture", cv::WINDOW_AUTOSIZE);
    cv::imshow("DisplayPicture", img);
    cv::waitKey(0);
    cv::destroyWindow("DisplayPicture");
    return 0;
}
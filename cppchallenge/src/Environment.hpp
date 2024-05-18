#include <string>

class ISource {
    public:
        virtual ~ISource(){};
        virtual std::string get(std::string) const = 0;
};

class Variables {
    public:
        Variables(ISource*);
        ~Variables();
        std::string get(std::string);
    private:
        ISource* msource;
};

class OSSource: public ISource {
    public:
        OSSource(){};
        ~OSSource(){};
        std::string get(std::string) const override;
};
